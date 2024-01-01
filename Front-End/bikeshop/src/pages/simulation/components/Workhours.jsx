import {
  FormControl,
  Input,
  InputLabel,
  FormHelperText,
  Tooltip,
  Box,
  Typography,
  Grid,
} from "@mui/material";
import React, { useState, useEffect } from "react";
import { useTranslation } from "react-i18next";
import { useGlobalState } from "../../../components/GlobalStateProvider";
import { InfoOutlined } from "@mui/icons-material";
import { toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

function Workinghours({ data, calculations, validate }) {
  const [items, setItems] = useState([]);
  const fSetGlobalValid = validate;
  const { t, i18n } = useTranslation();
  const { state, setState } = useGlobalState();
  const [iMaxNumber, setMaxNumber] = useState(240);

  const allowedKeys = [
    "ArrowLeft",
    "ArrowRight",
    "Backspace",
    "ArrowUp",
    "ArrowDown",
    "Tab",
  ];

  useEffect(() => {
    setItems(state["workingtimelist"]);
  }, [items]);

  const getCalculationExplanation = (element) => {
    if (calculations) {
      const calculation = calculations.find((calc) => calc.element === element);
      if (calculation) {
        return calculation.explanation;
      }
    }
    return " ";
  };

  return (
    <Box>
      <Tooltip arrow title={t("simulation.tooltipWorkhours")}>
        <InfoOutlined />
      </Tooltip>
      <Box sx={{ fontSize: "14px", textAlign: "start" }}>
        <Typography>{t("simulation.workhoursInfo.info1")}</Typography>
        <br />
        <Typography>{t("simulation.workhoursInfo.info2")}</Typography>
        <br />
        <Typography>{t("simulation.workhoursInfo.info3")}</Typography>
        <br />
        <Typography>{t("simulation.workhoursInfo.info4")}</Typography>
        <br />
        <Typography>{t("simulation.workhoursInfo.info5")}</Typography>
        <br />
      </Box>
      {items &&
        items.length > 0 &&
        items.map((oElement) => {
          return (
            <Box
              key={oElement.station}
              sx={{
                margin: "2rem",
                padding: "1rem",
                boxShadow: "0px 4px 6px rgba(0, 0, 0, 0.1)",
                borderRadius: "8px",
                backgroundColor: "#ffffff",
                width: "650px",
              }}
            >
              <Typography
                variant="h5"
                sx={{ fontWeight: "bold", marginBottom: "1rem" }}
              >
                {t("simulation.workstation")} {oElement.station}:
              </Typography>
              <Grid container spacing={2}>
                <Grid item xs={6}>
                  <FormControl fullWidth>
                    <InputLabel>{t("simulation.shift")}</InputLabel>
                    <Input
                      type="number"
                      id={"inputshift" + oElement.station}
                      aria-describedby="form-helper"
                      onInput={(oEvent) => {
                        // ... (Ihre vorhandenen Eingabehandler)
                      }}
                      inputProps={{
                        min: 0,
                        max: 3,
                        onKeyDown: (event) => {
                          // ... (Ihre vorhandenen Eingabehandler)
                        },
                      }}
                      value={oElement.shift}
                      onChange={(oEvent) => {
                        // ... (Ihre vorhandenen Eingabehandler)
                      }}
                    />
                  </FormControl>
                  {calculations && (
                    <Typography variant="body2" marginTop="0.5rem">
                      Produktions- und Rüstzeiten:{" "}
                      {getCalculationExplanation(oElement.station)}
                    </Typography>
                  )}
                </Grid>
                <Grid item xs={6}>
                  <FormControl fullWidth>
                    <InputLabel>{t("simulation.overtime")}</InputLabel>
                    <Input
                      id={"inputovertime" + oElement.station}
                      type="number"
                      inputProps={{
                        min: 0,
                        max: iMaxNumber,
                        onKeyDown: (event) => {
                          // ... (Ihre vorhandenen Eingabehandler)
                        },
                      }}
                      defaultValue={oElement.overtime}
                      onInput={(oEvent) => {
                        // ... (Ihre vorhandenen Eingabehandler)
                      }}
                      onChange={(oEvent) => {
                        // ... (Ihre vorhandenen Eingabehandler)
                      }}
                    />
                  </FormControl>
                </Grid>
              </Grid>
            </Box>
          );
        })}
    </Box>
  );
}

export default Workinghours;
