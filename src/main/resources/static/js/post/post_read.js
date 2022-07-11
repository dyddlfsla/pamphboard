let process = 'none';
const idx = $('#postIdx').val();
const password = $('#password');
const readPost = {
  init: function () {
    let innerThis = this;
    let isPWCorrect;
    $('.btn_return_list').on('click', function () {
      location.href = '/post/list';
    });
    $('.btn_modify').on('click', function () {
      $('.verify_box').css('visibility', 'visible');
      process = 'modify';
      innerThis.emptyBox();
    });
    $('.btn_delete').on('click', function () {
      $('.verify_box').css('visibility', 'visible');
      process = 'delete';
      innerThis.emptyBox();
    })
    $('.verify_cancel').on('click', function () {
      $('.verify_box').css('visibility', 'hidden');
    })
    $('#password').on('keyup', function (event) {
      if (event.keyCode === 13) {
        isPWCorrect = innerThis.verify();
        if (isPWCorrect && process === 'modify') {
          innerThis.modify();
        }
        if (isPWCorrect && process === 'delete') {
          innerThis.delete();
        }
        if (!isPWCorrect) {
          alert('비밀번호가 일치하지 않습니다. 다시 확인해주세요.');
          password.select();
        }
      }
    })
  },

  verify: function () {
    let isPWCorrect
    let data = {
      postIdx: idx,
      password: password.val()
    };
    $.ajax({
      type: 'POST',
      url: `/api/pamphboard/post/verify/password`,
      dataType: 'json',
      data: data,
      async: false,
    }).done(function (result) {
      isPWCorrect = result;
    }).fail(function (error) {
      alert(`관리자에게 문의하세요. error : ${JSON.stringify(error)}`);
    })
    return isPWCorrect;
  },

  comment: function () {
    if (process === 'modify') {
      return '수정하시겠습니까?';
    }
    if (process === 'delete') {
      return '삭제하시겠습니까?';
    }
  },

  emptyBox: function() {
    password.val('');
    password.focus();
  },

  modify: function() {
    location.href = `/post/modify/${idx}`;
  },

  delete: function() {
    if(confirm(`${this.comment()}`)) {
      $.ajax({
        type: 'DELETE',
        url: `/api/pamphboard/post/${idx}`,
      }).done(function () {
        alert(`글이 삭제되었습니다.`);
        location.href = '/post/list';
      }).fail(function (error) {
        alert(`관리자에게 문의하세요. error : ${JSON.stringify(error)}`);
      });
    }
  }
}

readPost.init();