$(function () {
  loadData();
});

/**
 * 标签栏首页点击事件刷新方法
 */
function loadData() {
  getWestMicrowaveInfo();
  getEastMicrowaveInfo();
  getWestHeatSum();
  getEastHeatSum();
}

var westZoneName = '西区';
var eastZoneName = '东区';

/**
 * 获取微波炉信息
 */
function getWestMicrowaveInfo() {
  $.ajax({
    url: 'microsoft/' + westZoneName,
    type: 'GET',
    data: {},
    success: function (res) {
      if (res.code == '200') {

        switch (res.data.microwaveStatus) {
          case 0:
            $("span[name='westMwStatusName']").attr("class",
                "label label-primary pull-right");
            break;
          case 1:
            $("span[name='westMwStatusName']").attr("class",
                "label label-success pull-right");
            break;
          case 2:
            $("span[name='westMwStatusName']").attr("class",
                "label label-danger pull-right");
            break;
        }

        $("span[name='westMwStatusName']").text(res.data.microwaveStatusName);
        $("h1[name='westMwStatusName']").text(res.data.microwaveStatusName);
      } else {
        console.log(res);
      }
    }
  });
}

function getEastMicrowaveInfo() {
  $.ajax({
    url: 'microsoft/' + eastZoneName,
    type: 'GET',
    data: {},
    success: function (res) {
      if (res.code == '200') {

        switch (res.data.microwaveStatus) {
          case 0:
            $("span[name='eastMwStatusName']").attr("class",
                "label label-primary pull-right");
            break;
          case 1:
            $("span[name='eastMwStatusName']").attr("class",
                "label label-success pull-right");
            break;
          case 2:
            $("span[name='eastMwStatusName']").attr("class",
                "label label-danger pull-right");
            break;
        }

        $("span[name='eastMwStatusName']").text(res.data.microwaveStatusName);
        $("h1[name='eastMwStatusName']").text(res.data.microwaveStatusName);
      } else {
        console.log(res);
      }
    }
  });
}

/**
 * 获取总热饭人数
 */
function getWestHeatSum() {
  $.ajax({
    url: 'heat/history/' + westZoneName,
    type: 'GET',
    data: {},
    success: function (res) {
      if (res.code == '200') {
        console.log(res.data);
        $("h1[name='westHeatSum']").text(res.data);
      } else {
        console.log(res);
      }
    }
  });
}

function getEastHeatSum() {
  $.ajax({
    url: 'heat/history/' + eastZoneName,
    type: 'GET',
    data: {},
    success: function (res) {
      if (res.code == '200') {
        console.log(res.data);
        $("h1[name='eastHeatSum']").text(res.data);
      } else {
        console.log(res);
      }
    }
  });
}

