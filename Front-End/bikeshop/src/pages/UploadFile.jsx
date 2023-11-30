import { Button, Box, Typography } from "@mui/material";
import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import { xml2json } from "xml-js";

function FileUpload() {
  const [oFileToUpload, fSetFileToUpload] = useState();
  // const [bFileLoaded, fSetFileLoaded] = useState(false);
  // const navigate = useNavigate();
  const fHandeFileChange = (oEvent) => {
    fSetFileToUpload(oEvent.target.files[0]);
  };
  const fSendFile = async () => {
    const frXMLReader = new FileReader();
    let file = {};
    frXMLReader.readAsText(oFileToUpload);

    frXMLReader.onloadend = async (oEvent) => {
      file = {
        content: oEvent.target.result,
      };
      file.content = JSON.parse(xml2json(file.content)).elements[0];

      try {
        await axios
          .post("http://localhost:8080/api/import", file.content, {
            headers: {
              "Content-Type": "application/json",
            },
          })
          .then((oResponse) => {
            if (oResponse.status === 200) {
              // window.location.replace("http://localhost:5173/simulation");
              // navigate("/Simulation");
            } else {
            }
          });
      } catch (error) {
        console.error("Fehler beim Einlesen der XML-Datei:", error);
      }
    };
  };

  return (
    <>
      <Box>
        <Typography marginBottom="5rem"></Typography>
        <input type="file" accept=".xml" onChange={fHandeFileChange} />
        {!!oFileToUpload && (
          <Button variant="contained" onClick={fSendFile}>
            Datei hochladen
          </Button>
        )}
      </Box>
    </>
  );
}

export default FileUpload;
