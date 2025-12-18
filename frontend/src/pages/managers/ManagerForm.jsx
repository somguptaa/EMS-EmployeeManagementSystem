import { useEffect, useState } from "react";
import { TextField, Button, Box } from "@mui/material";
import api from "../../api";

export default function ManagerForm({ selected, onSaved }) {
  const [manager, setManager] = useState({
    mngName: "",
    mngaddress: "",
    email: "",
    salary: "",
    dept: ""
  });

  useEffect(() => {
    if (selected) setManager(selected);
  }, [selected]);

  const handleChange = (e) => {
    setManager({ ...manager, [e.target.name]: e.target.value });
  };

  const handleSubmit = async () => {
    if (!manager.mngName || !manager.email || !manager.dept) {
      alert("Name, Email and Department are required");
      return;
    }

    if (manager.id) {
      // UPDATE
      await api.put(`/managers/${manager.id}`, manager);
    } else {
      // CREATE
      await api.post("/managers", manager);
    }

    setManager({
      mngName: "",
      mngaddress: "",
      email: "",
      salary: "",
      dept: ""
    });

    onSaved();
  };

  return (
    <Box sx={{ mb: 3 }}>
      <TextField
        label="Manager Name"
        name="mngName"
        value={manager.mngName}
        onChange={handleChange}
        sx={{ mr: 2 }}
      />

      <TextField
        label="Address"
        name="mngaddress"
        value={manager.mngaddress}
        onChange={handleChange}
        sx={{ mr: 2 }}
      />

      <TextField
        label="Email"
        name="email"
        value={manager.email}
        onChange={handleChange}
        sx={{ mr: 2 }}
      />

      <TextField
        label="Salary"
        name="salary"
        type="number"
        value={manager.salary}
        onChange={handleChange}
        sx={{ mr: 2 }}
      />

      <TextField
        label="Department"
        name="dept"
        value={manager.dept}
        onChange={handleChange}
        sx={{ mr: 2 }}
      />

      <Button variant="contained" onClick={handleSubmit}>
        {manager.id ? "Update" : "Add"}
      </Button>
    </Box>
  );
}
