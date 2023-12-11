import { FormControl, MenuItem, Select } from "@mui/material";
import { useState } from "react";
import { useTranslation } from "react-i18next";
import { useGlobalState } from "../../../components/GlobalStateProvider";

function SequenceNumberMenu(data) {
  const { t, i18n } = useTranslation();
  const { state, setState } = useGlobalState();

  //const [iSequenceNumber, fSetSequenceNumber] = useState(data.value);
  const oElement = data.element;
  const fHandleChange = (oEvent) => {
    const oNewSequence = data.sequence;
    const fSetnewSequence = data.setSequence;
    const iNewSequenceNumber = oEvent.target.value;
    //fSetSequenceNumber(iNewSequenceNumber);
    const oNewState = state;
    const oIndex = oNewState["productionlist"].find(
      (oObject) => oObject.article === oElement.article
    );
    const iIndex = oNewState["productionlist"].indexOf(oIndex);
    const iOldSequenceNumber = oIndex.sequenceNumer;
    const oReplaceIndex = oNewState["productionlist"].find(
      (oObject) => oObject.sequenceNumer === iNewSequenceNumber
    );
    const iReplaceIndex = oNewState["productionlist"].indexOf(oReplaceIndex);

    oNewState["productionlist"][iIndex].sequenceNumer = iNewSequenceNumber;
    oNewState["productionlist"][iReplaceIndex].sequenceNumer =
      iOldSequenceNumber;
    setState(oNewState);
    oNewSequence[oIndex.article] = iNewSequenceNumber;
    oNewSequence[oReplaceIndex.article] = iOldSequenceNumber;
    fSetnewSequence(oNewSequence);
  };

  return (
    <Select
      defaultValue={data.sequence[oElement.article]}
      label={t("simulation.sequenceNumber")}
      onChange={fHandleChange}
      key={oElement.article}
    >
      {state.productionlist
        .sort((a, b) => a.sequenceNumer - b.sequenceNumer)
        .map((oSequenceItem) => {
          return (
            <MenuItem value={oSequenceItem.sequenceNumer}>
              {oSequenceItem.sequenceNumer}
            </MenuItem>
          );
        })}
    </Select>
  );
}

export default SequenceNumberMenu;
