function filterTable(tableId, colNum, boxName) {
    // Declare variables
    var input, filter, table, tr, td, i;
    input = document.getElementById(boxName);
    filter = input.value.toUpperCase();
    table = document.getElementById(tableId);
    tr = table.getElementsByTagName("tr");

    // Loop through all table rows, and hide those who don't match the search query
    for (i = 0; i < tr.length; i++) {
        td = tr[i].getElementsByTagName("td")[colNum];
        if (td) {
            if (td.innerHTML.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
}


function filterBooksTable() {
    // Declare variables
    var titleBox, authorBox, titleFilter, authorFilter, table, tr, td, i;

    titleBox = document.getElementById("titleBox");
    authorBox = document.getElementById("authorBox");

    titleFilter = titleBox.value.toUpperCase();
    authorFilter = authorBox.value.toUpperCase();

    table = document.getElementById("booksTable");
    tr = table.getElementsByTagName("tr");

    // Loop through all table rows, and hide those who don't match the search query
    for (i = 0; i < tr.length; i++) {
        tdTitle = tr[i].getElementsByTagName("td")[0];
        tdAuthor = tr[i].getElementsByTagName("td")[2];

        if (tdTitle) {
            if (tdTitle.innerHTML.toUpperCase().indexOf(titleFilter) > -1 && tdAuthor.innerHTML.toUpperCase().indexOf(authorFilter) > -1) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
}