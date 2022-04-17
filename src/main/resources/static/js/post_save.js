const saveForm = document.querySelector("form");
const save = function () {
  if (confirm("등록하시겠습니까?")) {
    saveForm.submit();
  }
}
