import { Drawer, List, ListItemButton, ListItemText } from "@mui/material";
import { useNavigate } from "react-router-dom";

export default function Sidebar() {
  const navigate = useNavigate();

  return (
    <Drawer
      variant="permanent"
      sx={{
        width: 240,
        "& .MuiDrawer-paper": { width: 240 }
      }}
    >
      <List sx={{ mt: 8 }}>
        <ListItemButton onClick={() => navigate("/dashboard")}>
          <ListItemText primary="Dashboard" />
        </ListItemButton>

        <ListItemButton onClick={() => navigate("/employees")}>
          <ListItemText primary="Employees" />
        </ListItemButton>

        <ListItemButton onClick={() => navigate("/managers")}>
          <ListItemText primary="Managers" />
        </ListItemButton>
      </List>
    </Drawer>
  );
}
