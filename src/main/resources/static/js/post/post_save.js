const create = {
  init: function () {
    let innerThis = this;
    $('.btn_save').on('click', function () {
      if (confirm('등록하시겠습니까?')) {
        innerThis.save();
      }
    });
    $('.btn_cancel').on('click', innerThis.cancel);
  },

  save: function () {
    let formData = {
      author: $('#author').val(),
      password: $('#password').val(),
      title: $('#title').val(),
      content: $('#content').val(),
    };
    $.ajax({
      type: 'POST',
      url: '/api/pamphboard/post/',
      dataType: 'json',
      contentType: 'application/json; charset=utf-8',
      data: JSON.stringify(formData),
    }).done(function () {
      alert('글이 등록되었습니다.');
      window.location.href = '/post/list';
    }).fail(function (error) {
      alert(`관리자에게 문의하세요. error : ${JSON.stringify(error)}`);
    })
  },

  cancel: function () {
    window.location.href = '/post/list';
  }
};

create.init();
