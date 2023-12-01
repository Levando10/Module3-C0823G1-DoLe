$(document).ready(function() {
    // Example data for around 20 machines
    var data = [
      { name: "Machine 1", startTime: "2023-11-29 08:00:00", endTime: "2023-11-29 17:00:00", status: "Inactive", price: 10.0 },
      { name: "Machine 2", startTime: "2023-11-29 09:30:00", endTime: "2023-11-29 18:45:00", status: "Inactive", price: 12.5 },
      // Add more rows as needed
      // ...
      { name: "Machine 20", startTime: "2023-11-29 10:15:00", endTime: "2023-11-29 19:30:00", status: "Inactive", price: 15.0 }
    ];
  
    // Function to calculate the used time
    function calculateUsedTime(startTime, endTime) {
      var start = new Date(startTime);
      var end = new Date(endTime);
      var diff = end - start;
      var hours = Math.floor(diff / 3600000);
      var minutes = Math.floor((diff % 3600000) / 60000);
      return hours + "h " + minutes + "m";
    }
  
    // Function to handle the button click event
    function handleButtonClick(rowData, rowIndex) {
      // Update the status to 'Active'
      rowData.status = "Active";
      
      // Update the button color to red
      $('#vendingMachineTable').DataTable().cell(rowIndex, 4).data('<button class="btn btn-danger" disabled>Đã bật</button>').draw();
  
      // You may also want to update the start time when the machine is turned on
      // rowData.startTime = new Date(); // Uncomment this line if you want to update the start time
  
      // You can perform other actions here, such as starting a timer, etc.
    }
  
    // Example function to handle service selection
    function handleServiceSelection(rowData, rowIndex) {
      // Replace this with your actual code to handle service selection
      alert("Selected service for machine " + rowData.name);
    }
  
    // Populate the DataTable with data
    var table = $('#vendingMachineTable').DataTable({
      data: data,
      columns: [
        { data: 'name' },
        { data: 'startTime' },
        { data: 'endTime' },
        { 
          data: function(row) {
            return calculateUsedTime(row.startTime, row.endTime);
          }
        },
        { 
          data: function(row, type, rowIdx, meta) {
            if (type === 'display' && row.status === 'Inactive') {
              return '<button class="btn btn-success" onclick="handleButtonClick(' + JSON.stringify(row) + ', ' + rowIdx + ')">Bật máy</button>';
            } else if (type === 'display' && row.status === 'Active') {
              return '<button class="btn btn-danger" disabled>Đã bật</button>';
            }
            return row.status;
          }
        },
        { data: 'status' },
        { 
          data: function(row, type, rowIdx, meta) {
            if (type === 'display' && row.status === 'Inactive') {
              return '<button class="btn btn-primary" onclick="handleServiceSelection(' + JSON.stringify(row) + ', ' + rowIdx + ')">Chọn dịch vụ</button>';
            }
            return '';
          }
        },
        { data: 'price' }
      ]
    });
  });
  