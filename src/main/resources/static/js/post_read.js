let process = 'none';
const idx = $('#postIdx').val();
const Read = {
  init: function () {
    let innerThis = this;
    $('.btn_return_list').on('click', function () {
      location.href = '/post/list';
    });
    $('.btn_update').on('click', function () {
      $('.verify_box').css('visibility', 'visible');
      process = 'modify';
    });
    $('.btn_delete').on('click', function () {
      $('.verify_box').css('visibility', 'visible');
      process = 'delete';
    })
    $('.verify_cancel').on('click', function () {
      $('.verify_box').css('visibility', 'hidden');
    })
    $('#password').on('keyup', function (event) {
      if (event.keyCode === 13) {
        if (confirm(`${innerThis.comment()}`)) {
          innerThis.verify();
        }
      }
    })
  },

  verify: function () {
    let data = {
      postIdx: idx,
      password: $('#password').val()
    };
    $.ajax({
      type: 'POST',
      url: `/verify/password/`,
      dataType: 'json',
      data: data,
    }).done(function (result) {
      if (result && process === 'modify') {
        location.href = `/post/modify/${idx}`;
      }
      if (result && process === 'delete') {
        //삭제 요청
      }
      if (!result) {
        alert('비밀번호가 일치하지 않습니다. 다시 확인해주세요.');
      }
    }).fail(function (error) {
      alert(`관리자에게 문의하세요. error : ${JSON.stringify(error)}`);
    })
  },

  comment: function () {
    if (process === 'modify') {
      return '수정하시겠습니까?';
    }
    if (process === 'delete') {
      return '삭제하시겠습니까?';
    }
  },

}

Read.init();