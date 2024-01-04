import {
  Paper,
  Table,
  TableBody,
  TableCell,
  TableContainer,
  TableHead,
  TableRow,
  Tooltip,
} from "@mui/material";
import { Box } from "@mui/system";
import { useGlobalState } from "../../../components/GlobalStateProvider";
import { useTranslation } from "react-i18next";

import { InfoOutlined } from "@mui/icons-material";

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
    <>
      <Box alignContent="center">
        <Box>
          <Tooltip arrow title={t("simulation.tooltipOverview")} 
              sx={{ m: "16px 0 -24px 32px" }}>
            <InfoOutlined />
          </Tooltip>
        </Box>
        <Box sx={{ m: 3 }}>
          <TableContainer component={Paper}>
            <Table>
              <TableHead>
                <TableRow>
                  <TableCell>{t("simulation.orderListOverview")}</TableCell>
                </TableRow>
              </TableHead>
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
            </Table>
          </TableContainer>
        </Box>
        <Box margin="2rem">
          <TableContainer component={Paper}>
            <Table>
              <TableHead>
                <TableRow>
                  <TableCell>
                    {t("simulation.productionListOverview")}
                  </TableCell>
                </TableRow>
              </TableHead>
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
            </Table>
          </TableContainer>
        </Box>
        <Box margin="2rem">
          <TableContainer component={Paper}>
            <Table>
              <TableHead>
                <TableRow>
                  <TableCell>
                    {t("simulation.workingTimeListOverview")}
                  </TableCell>
                </TableRow>
              </TableHead>
              <TableHead>
                <TableRow>
                  <TableCell>{t("simulation.workstation")}</TableCell>
                  <TableCell>{t("simulation.shifts")}</TableCell>
                  <TableCell>{t("simulation.overtime")}</TableCell>
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
            </Table>
          </TableContainer>
        </Box>
      </Box>
    </>
  );
}
export default Overview;
