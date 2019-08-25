
function highURL(menuId, classCur, activeNode) {
    if (!document.getElementById)
        return false;
    if (!document.getElementById(menuId))
        return false;
    if (!document.getElementsByTagName)
        return false;
    var menuId = document.getElementById(menuId);
    var links = menuId.getElementsByTagName("a");
    for (var i = 0; i < links.length; i++) {
        var menuLink = links[i].getAttribute('href');
        // var menuLink = links[i].href;
        var currentLink = window.location.pathname;
        if (currentLink == menuLink) {
            // if (currentLink.indexOf(menuLink) > -1) {
            if (activeNode == 'li') {
                links[i].className = "curr";
                links[i].parentNode.className = classCur;
            } else {
                links[i].className = classCur;
            }
        }
    }
}
//
// window.onload = function highThis() {
//     highURL("nav-banner", "active", "li");
// }