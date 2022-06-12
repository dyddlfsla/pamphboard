const Modify = {
  init: function () {
    let innerThis = this;
    $('.btn_update').on('click', function() {
      if (confirm('수정하시겠습니까?')) {
        innerThis.update();
      }
    });
    $('.btn_cancel').on('click', innerThis.cancel);
  },

  update: function() {
    let updateData = {
      postIdx : $('#postIdx').val(),
      title: $('#title').val(),
      content: $('#content').val()
    };
    $.ajax({
      type: 'PUT',
      url: `/api/pamphboard/post/update/`,
      dataType: 'json',
      contentType: 'application/json; utf-8',
      data: JSON.stringify(updateData),
    }).done(function () {
      alert('글이 수정되었습니다.');
      location.href = `/post/read/${updateData.postIdx}`;
    }).fail(function(error) {
      alert(`관리자에게 문의하세요. error : ${JSON.stringify(error)}`);
    })
  },

  cancel: function() {
    history.back();
  }
}

Modify.init();




