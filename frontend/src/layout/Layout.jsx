import { Box, AppBar, Toolbar, Typography, CssBaseline } from "@mui/material";
import Sidebar from "./Sidebar";

const Layout = ({ children }) => {
  return (
    <Box sx={{ display: "flex", minHeight: "100vh" }}>
      <CssBaseline />

      {/* TOP BAR */}
      <AppBar position="fixed" sx={{ zIndex: 1201 }}>
        <Toolbar>
          <Typography variant="h6">EMS Dashboard</Typography>
        </Toolbar>
      </AppBar>

      {/* SIDEBAR */}
      <Sidebar />

      {/* MAIN CONTENT */}
      <Box
        component="main"
        sx={{
          flexGrow: 1,
          p: 3,
          mt: 8, // space below AppBar
          backgroundColor: "#f9fafb"
        }}
      >
        {children}
      </Box>
    </Box>
  );
};

export default Layout;
