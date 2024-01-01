import { Card, Typography } from "@mui/material";
import React from "react";
import { useTranslation } from "react-i18next";

export default function Home() {
  const { t, i18n } = useTranslation();
  return (
    <Card style={{ padding: "200px", margin: "auto" }}>
      <Typography
        variant="h4"
        component="h3"
        style={{
          padding: "25px",
          margin: "auto",
          color: "rgb(0, 0, 0)",
        }}
      >
        Bikeshop SCS Tool
      </Typography>
      <Typography>{t("home.welcomeText")}</Typography>
    </Card>
  );
}
