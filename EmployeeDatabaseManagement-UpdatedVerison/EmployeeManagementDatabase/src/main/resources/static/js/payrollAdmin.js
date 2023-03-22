// todo: Show table from button

const newPayRollBtn = document.getElementById("NewPayroll");
newPayRollBtn.addEventListener("click", () => {
    const payrollTable = document.getElementById("PayrollTable");

    payrollTable.style.display = "table";
    newPayRollBtn.style.display = "none";
});