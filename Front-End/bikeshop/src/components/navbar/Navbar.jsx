import React, { useState } from "react";
import {
  AppBar,
  Toolbar,
  Typography,
  Select,
  MenuItem,
  styled,
  IconButton,
  Menu,
} from "@mui/material";
import { useTranslation } from "react-i18next";
import LanguageIcon from "@mui/icons-material/Language";

const StyledAppBar = styled(AppBar)(({ theme }) => ({
  backgroundColor: "#669999",
  boxShadow: "0px 2px 4px rgba(0, 0, 0, 0.2)",
}));

const StyledTypography = styled(Typography)({
  flexGrow: 1,
  fontSize: "1.5rem",
  color: "#000",
  marginLeft: "20px",
});

const StyledSelect = styled(Select)({
  color: "grey",
  marginLeft: "20px",
});

function Navbar() {
  const { t, i18n } = useTranslation("translation");
  const [sLanguage, setLanguage] = useState(i18n.language.toLowerCase());
  const [anchorEl, setAnchorEl] = useState(null);

  const handleLanguageMenuOpen = (event) => {
    setAnchorEl(event.currentTarget);
  };

  const handleLanguageMenuClose = () => {
    setAnchorEl(null);
  };

  const handleLanguageChange = (language) => {
    setLanguage(language);
    i18n.changeLanguage(language);
    handleLanguageMenuClose();
  };

  return (
    <StyledAppBar position="fixed">
      <Toolbar>
        <StyledTypography variant="h1">{t("navbar.appTitle")}</StyledTypography>
        <IconButton
          color="inherit"
          aria-label="language"
          onClick={handleLanguageMenuOpen}
        >
          <LanguageIcon />
        </IconButton>
        <Menu
          anchorEl={anchorEl}
          open={Boolean(anchorEl)}
          onClose={handleLanguageMenuClose}
        >
          <MenuItem onClick={() => handleLanguageChange("de")}>
            {t("navbar.german")}
          </MenuItem>
          <MenuItem onClick={() => handleLanguageChange("en")}>
            {t("navbar.english")}
          </MenuItem>
        </Menu>
      </Toolbar>
    </StyledAppBar>
  );
}

export default Navbar;
