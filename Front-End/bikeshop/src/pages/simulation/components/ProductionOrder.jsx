import React, { useEffect, useState } from "react";
import { useTranslation } from "react-i18next";
import { Box } from "@mui/system";
import {
  Grid,
  List,
  MenuItem,
  Typography,
  ListItem,
  ListItemText,
  Select,
  Tooltip,
  InputLabel,
} from "@mui/material";
import { useGlobalState } from "../../../components/GlobalStateProvider";
import { InfoOutlined } from "@mui/icons-material";

function ProductionOrder(props) {
  const [items, setItems] = useState([]);
  const { state, setState } = useGlobalState();
  const { t, i18n } = useTranslation();

  const handleSequenceNumberChange = (itemId, newSequenceNumber) => {
    const newState = state;
    const otherObject = state["productionlist"].find(
      (oObject) => oObject.sequenceNumer === newSequenceNumber
    );
    const currentObject = state["productionlist"].find(
      (oObject) => oObject.id === itemId
    );
    const iOldSequenceNumber = currentObject.sequenceNumer;
    const iCurrentIndex = state["productionlist"].indexOf(currentObject);
    const iOtherIndex = state["productionlist"].indexOf(otherObject);

    newState["productionlist"][iCurrentIndex].sequenceNumer = newSequenceNumber;
    newState["productionlist"][iOtherIndex].sequenceNumer = iOldSequenceNumber;
    newState["productionlist"].sort(
      (a, b) => a.sequenceNumer - b.sequenceNumer
    );
    setItems(newState["productionlist"]);
    setState(newState);
  };

  useEffect(() => {
    setItems(props.data);
  }, [state]);

  return (
    <Box display="flex" justifyContent="center" alignItems="center">
      <Box maxWidth="800px">
        <Tooltip arrow title={t("simulation.tooltipProductionProgram")}>
          <InfoOutlined />
        </Tooltip>

        <List sx={{ width: "100%" }}>
          {items &&
            items.map((oItem) => {
              return (
                <ListItem
                  key={oItem.id}
                  sx={{
                    display: "flex",
                    alignItems: "center",
                    justifyContent: "space-between",
                    padding: "1rem",
                    marginBottom: "0.5rem",
                    boxShadow: "0px 2px 4px rgba(0, 0, 0, 0.1)",
                    borderRadius: "8px",
                    backgroundColor: "#fff",
                    width: "100%",
                  }}
                >
                  <Box>
                    <Typography variant="body1">
                      {t("simulation.part")}
                    </Typography>
                    <Typography variant="body2">{oItem.article}</Typography>
                  </Box>
                  <Box>
                    <InputLabel>{t("simulation.sequenceNumber")}</InputLabel>
                    <Select
                      variant="outlined"
                      value={oItem.sequenceNumer}
                      onChange={(e) =>
                        handleSequenceNumberChange(
                          oItem.id,
                          parseInt(e.target.value)
                        )
                      }
                      sx={{ marginLeft: "10px", width: "6rem" }}
                    >
                      {[...Array(state["productionlist"].length)].map(
                        (_, index) => (
                          <MenuItem key={index} value={index + 1}>
                            {index + 1}
                          </MenuItem>
                        )
                      )}
                    </Select>
                  </Box>
                </ListItem>
              );
            })}
        </List>
      </Box>
    </Box>
  );
}

export default ProductionOrder;
