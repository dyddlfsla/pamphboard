const activeMenu = function () {
  if (location.href.indexOf('home') >= 0) {
    $('.home').attr('class', 'home active');
  }
  if (location.href.indexOf('post') >= 0) {
    $('.post').attr('class', 'post active');
  }
}

activeMenu();