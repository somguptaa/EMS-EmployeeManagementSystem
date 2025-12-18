import { Typography, Grid, Card, CardContent } from "@mui/material";
import { useNavigate } from "react-router-dom";

export default function Dashboard() {
  const navigate = useNavigate();

  return (
    <>
      <Typography variant="h4" gutterBottom>
        Welcome to EMS Dashboard
      </Typography>

      <Typography variant="body1" sx={{ mb: 3 }}>
        Manage employees and managers efficiently from one place.
      </Typography>

      <Grid container spacing={3}>
        {/* Employees Card */}
        <Grid item xs={12} md={6}>
          <Card
            sx={{
              cursor: "pointer",
              height: "100%",
              "&:hover": { boxShadow: 6 }
            }}
            onClick={() => navigate("/employees")}
          >
            <CardContent>
              <Typography variant="h6" gutterBottom>
                Employees
              </Typography>
              <Typography variant="body2">
                Add, update, search, and delete employee records.
              </Typography>
            </CardContent>
          </Card>
        </Grid>

        {/* Managers Card */}
        <Grid item xs={12} md={6}>
          <Card
            sx={{
              cursor: "pointer",
              height: "100%",
              "&:hover": { boxShadow: 6 }
            }}
            onClick={() => navigate("/managers")}
          >
            <CardContent>
              <Typography variant="h6" gutterBottom>
                Managers
              </Typography>
              <Typography variant="body2">
                Manage manager information and records.
              </Typography>
            </CardContent>
          </Card>
        </Grid>
      </Grid>
    </>
  );
}
