function login() {
  var username = $('#username').val();
  var password = $('#password').val();

  if (username == '') {
    swal({
      title: "登录失败",
      text: "请输入账号",
      type: "warning",
      timer: 2000
    });
    return;
  }

  if (password == '') {
    swal({
      title: "登录失败",
      text: "请输入密码",
      type: "warning",
      timer: 2000
    });
    return;
  }

  $.ajax({
    url: 'toIndex',
    type: 'POST',
    data: {
      "username": username,
      "password": password
    },
    success: function (res) {
      if (res.code == '200') {
        window.location.href = 'index';
      } else if (res.code == '201') {
        swal({
          title: "登录失败",
          text: res.msg,
          type: "warning",
          timer: 3000
        });
      } else {
        swal({
          title: "登录失败",
          text: res.msg,
          type: "error",
          timer: 3000
        });
      }
    }
  });
}