const Read = {
  init: function () {
    $('.btn_return_list').on('click', function () {
      location.href = '/post/list';
    });
    $('.btn_update').on('click', function () {
      location.href = 'post/update/[(${foundPost.postIdx)]';
    });
    $('.btn_delete').on('click', function() {
      location.href = 'post/delete/[(${foundPost.postIdx)]';
    })
  },

  verify: function() {
  }
}

Read.init();