import {
  Table,
  TableBody,
  TableCell,
  TableHead,
  TableRow,
  Tooltip,
  Accordion,
  AccordionSummary,
  AccordionDetails,
  Typography 
} from "@mui/material";
import { Box } from "@mui/system";
import { useGlobalState } from "../../../components/GlobalStateProvider";
import { useTranslation } from "react-i18next";
import { InfoOutlined } from "@mui/icons-material";
import ExpandMoreIcon from '@mui/icons-material/ExpandMore';

function Overview(props) {
  const { oState, fSetState } = useGlobalState();
  const { t, i18n } = useTranslation();

  const mModeMap = new Map([
    [1, t("simulation.shippingMethods.specialDelivery")],
    [2, t("simulation.shippingMethods.cheapVendor")],
    [3, t("simulation.shippingMethods.JIT")],
    [4, t("simulation.shippingMethods.fast")],
    [5, t("simulation.shippingMethods.normal")],
  ]);

  return (
    <Box>
      <Accordion sx={{ mt: 6 }}>
        <AccordionSummary
          expandIcon={<ExpandMoreIcon />}
          aria-controls="panel2a-content"
          id="panel2a-header"
        >
          <Typography>{t("simulation.orderListOverview")}</Typography>
        </AccordionSummary>
        <AccordionDetails>
          {<Table>
              <TableHead>
                <TableRow>
                  <TableCell>{t("simulation.part")}</TableCell>
                  <TableCell>{t("simulation.amount")}</TableCell>
                  <TableCell>{t("simulation.mode")}</TableCell>
                </TableRow>
              </TableHead>
              <TableBody>
                {props.data.orderlist.map((oOrder) => (
                  <TableRow key={oOrder.part}>
                    <TableCell>{oOrder.article}</TableCell>
                    <TableCell>{oOrder.quantity}</TableCell>
                    <TableCell>{mModeMap.get(oOrder.modus)}</TableCell>
                  </TableRow>
                ))}
              </TableBody>
            </Table>}
        </AccordionDetails>
      </Accordion>

      <Accordion>
        <AccordionSummary
          expandIcon={<ExpandMoreIcon />}
          aria-controls="panel2a-content"
          id="panel2a-header"
        >
          <Typography>{t("simulation.productionListOverview")}</Typography>
        </AccordionSummary>
        <AccordionDetails>
          {<Table>
            <TableHead>
              <TableRow>
                <TableCell>{t("simulation.part")}</TableCell>
                <TableCell>{t("simulation.amount")}</TableCell>
              </TableRow>
            </TableHead>
            <TableBody>
              {props.data.productionlist.map((oOrder) => (
                <TableRow key={oOrder.article}>
                  <TableCell>{oOrder.article}</TableCell>
                  <TableCell>{oOrder.quantity}</TableCell>
                </TableRow>
              ))}
            </TableBody>
          </Table>}
        </AccordionDetails>
      </Accordion>

      <Accordion>
        <AccordionSummary
          expandIcon={<ExpandMoreIcon />}
          aria-controls="panel2a-content"
          id="panel2a-header"
        >
          <Typography>{t("simulation.workingTimeListOverview")}</Typography>
        </AccordionSummary>
        <AccordionDetails>
          {<Table>
            <TableHead>
              <TableRow>
                <TableCell>{t("simulation.workstation")}</TableCell>
                <TableCell style={{ whiteSpace: "nowrap" }}>{t("simulation.shifts")}</TableCell>
                <TableCell style={{ whiteSpace: "nowrap" }}>{t("simulation.overtime")}</TableCell>
              </TableRow>
            </TableHead>
            <TableBody>
              {props.data.workingtimelist.map((oOrder) => (
                <TableRow key={oOrder.station}>
                  <TableCell>{oOrder.station}</TableCell>
                  <TableCell>{oOrder.shift}</TableCell>
                  <TableCell>{oOrder.overtime}</TableCell>
                </TableRow>
              ))}
            </TableBody>
          </Table>}
        </AccordionDetails>
      </Accordion>
    </Box>
  );
}
export default Overview;
