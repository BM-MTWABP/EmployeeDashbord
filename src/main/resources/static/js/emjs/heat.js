$(function () {
  tableInit();
});

/**
 * 初始化table的内容
 */
var $table;
var $heatTableForm;

function tableInit() {
  $heatTableForm = $(".heat-table-form");
  var queryUrl = 'heats';
  $table = $('#heatTable').bootstrapTable({
    url: queryUrl,
    method: 'GET',
    striped: false,
    pagination: true,
    paginationLoop: false,
    smartDisplay: false,
    sortable: false,
    sidePagination: "server",
    pageNumber: 1,
    pageSize: 10,
    pageList: [10, 25],
    minimumCountColumns: 2,
    contentType: "application/x-www-form-urlencoded",
    clickToSelect: false,
    uniqueId: "ID",
    queryParams: function (params) {
      var temp = {
        pageSize: params.limit,
        pageNum: params.offset / params.limit + 1,
        nickName: $heatTableForm.find("input[name='nickname']").val(),
        heatStatusValue: $heatTableForm.find("select[name='heat']").val(),
        zoneName: $heatTableForm.find("select[name='zone']").val()
      };
      return temp;
    },
    columns: [
      {
        field: 'heatId',
        title: 'ID'
      }, {
        field: 'nickName',
        title: '用户',
        formatter: function (value, row, index) {
          return '<img alt="image" class="img-circle" style="width: 30px; height: 30px;" src='
              + row.imgUrl + '>&nbsp;&nbsp;<span>'
              + row.nickName + '</span>';
        }
      }, {
        field: 'waitTime',
        title: '开始排队时间'
      }, {
        field: 'startTime',
        title: '热饭开始时间'
      }, {
        field: 'endTime',
        title: '热饭结束时间'
      }, {
        field: 'heatStatusName',
        title: '热饭状态'
      }, {
        field: 'zoneName',
        title: '所在区域'
      }],
    onLoadSuccess: function () {
    },
    onLoadError: function () {
      swal({
        title: "请求异常",
        text: "加载数据失败",
        type: "warning",
        timer: 3000
      });
    },
  });
};

/**
 * 搜索按钮方法
 */
function search() {
  $("#heatTable").bootstrapTable('refresh');
}

/**
 * 重置按钮方法
 */
function reload() {
  $heatTableForm.find("input[name='nickname']").val('');
  $heatTableForm.find("select[name='heat']").val('');
  $heatTableForm.find("select[name='zone']").val('西区');
  $("#heatTable").bootstrapTable('refresh');
}