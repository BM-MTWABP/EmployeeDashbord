$(function () {
  // table列表初始化
  tableInit();
});

var $table;
var $heatTableForm;

//初始化bootstrap-table的内容
function tableInit() {
  $heatTableForm = $(".heat-table-form");
  var queryUrl = 'heats';
  $table = $('#heatTable').bootstrapTable({
    url: queryUrl,                      //请求后台的URL（*）
    method: 'GET',                      //请求方式（*）
    striped: false,                      //是否显示行间隔色
    pagination: true,                   //是否显示分页（*）
    paginationLoop: false,
    smartDisplay: false,
    sortable: false,                     //是否启用排序
    sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
    pageNumber: 1,                      //初始化加载第一页，默认第一页,并记录
    pageSize: 10,                     //每页的记录行数（*）
    pageList: [10, 25],        //可供选择的每页的行数（*）
    minimumCountColumns: 2,             //最少允许的列数
    contentType: "application/x-www-form-urlencoded",
    clickToSelect: false,                //是否启用点击选中行
    uniqueId: "ID",                     //每一行的唯一标识，一般为主键列
    //得到查询的参数
    queryParams: function (params) {
      //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
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
        title: '昵称'
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
      showTips("数据加载失败！");
    },
  });
};

function search() {
  $("#heatTable").bootstrapTable('refresh');
}

function reload() {
  console.log('sssss');
  $heatTableForm.find("input[name='nickname']").val('');
  $heatTableForm.find("select[name='heat']").val('');
  $heatTableForm.find("select[name='zone']").val('西区');
  $("#heatTable").bootstrapTable('refresh');
}