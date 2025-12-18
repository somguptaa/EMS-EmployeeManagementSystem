import GenericCrudList from "../../common/GenericCrudList";
import ManagerForm from "./ManagerForm";

export default function ManagerPage() {
  return (
    <GenericCrudList
      title="Managers"
      apiPath="/managers"
      nameField="mngName"
      FormComponent={ManagerForm}
      columns={[
        { label: "ID", field: "id" },
        { label: "Name", field: "mngName" },
        { label: "Email", field: "email" },
        { label: "Department", field: "dept" },
        { label: "Salary", field: "salary" }
      ]}
    />
  );
}
