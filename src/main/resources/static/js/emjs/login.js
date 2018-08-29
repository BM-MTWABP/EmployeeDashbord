function login() {
  var username = $('#username').val();
  var password = $('#password').val();

  $.ajax({
    url: 'toIndex',
    type: 'POST',
    data: {
      "username": username,
      "password": password
    },
    success: function (res) {
      console.log(res.code);
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