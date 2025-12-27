import GenericCrudList from "../../common/GenericCrudList";
import EmployeeForm from "./EmployeeForm";

export default function EmployeePage() {
  return (
    <GenericCrudList
      title="Employees"
      apiPath="/employees"
      nameField="empName"
      FormComponent={EmployeeForm}
      columns={[
        { label: "ID", field: "id" },
        { label: "Name", field: "empName" },
        { label: "Email", field: "email" },
        { label: "Department", field: "dept" },
        { label: "Salary", field: "salary" }
      ]}
    />
  );
}
