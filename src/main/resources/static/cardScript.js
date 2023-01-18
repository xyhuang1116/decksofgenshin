var cardQueue = [];
for(let i = 1;i<=30;i++){
    c.push(i);
}
let elemNum = (window.innerWidth *0.8 /95 -1) | 0 ;

let br = -1;

localStorage.clear();

function addCardToDeck(id,codeName,type,subType) {

    let elem = document.getElementById('cardList');
    let th = document.createElement('th');
    let botton = document.createElement('button');
    let img = document.createElement('img');

    th.id = -cardQueue.shift().toString();

    botton.className = 'cardbutton';
    //TODO 
    botton.onclick = 'deleteCardToDeck(' + id + ')';

    img.src = '/image/card/' + type + '/' + subType + '/' + id + '.png'
    img.width = 50;
    img.height = 85;

    if(br == elemNum){
        elem.append(document.createElement('tr'));
        br = 0;
    }else{br++;}

    elem.append(th);
    th.append(botton);
    botton.append(img);

    // imgs[i].src= '/image/chara/icon/'.concat(id).concat('.png');

    // localStorage.setItem(queue.shift().toString(),codeName);

    // addExportBox();

}

function deleteCardToDeck(colId) {

    let elem = document.getElementById(colId);
    let img = elem.querySelectorAll('img');

    let deleteKey = colId.replace("colbutton", "");


    localStorage.removeItem(deleteKey);
    queue.push(parseInt(deleteKey));

    addExportBox();

    img[0].id = 'empty';
    img[0].src = '/image/empty_chara.png';
}


function deleteCharaToDeck(colId) {

    let elem = document.getElementById(colId);
    let img = elem.querySelectorAll('img');

    let deleteKey = colId.replace("colbutton", "");


    localStorage.removeItem(deleteKey);
    queue.push(parseInt(deleteKey));

    addExportBox();

    img[0].id = 'empty';
    img[0].src = '/image/empty_chara.png';
}


function addExportBox(){
    let deck = '';

    for(let i=0; i<localStorage.length; i++) {
        let key = localStorage.key(i);
        deck = deck + localStorage.getItem(key);
      }

    let deckCode = document.getElementById('deckCode');
    deckCode.value = deck;
}
