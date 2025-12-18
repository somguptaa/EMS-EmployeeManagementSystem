import { BrowserRouter, Routes, Route, Navigate } from "react-router-dom";
import Layout from "./layout/Layout";
import Dashboard from "./pages/dashboard/Dashboard";
import EmployeePage from "./pages/employees/EmployeePage";
import ManagerPage from "./pages/managers/ManagerPage";

export default function App() {
  return (
    <BrowserRouter>
      <Layout>
        <Routes>
          <Route path="/" element={<Navigate to="/dashboard" />} />
          <Route path="/dashboard" element={<Dashboard />} />
          <Route path="/employees" element={<EmployeePage />} />
          <Route path="/managers" element={<ManagerPage />} />
        </Routes>
      </Layout>
    </BrowserRouter>
  );
}
