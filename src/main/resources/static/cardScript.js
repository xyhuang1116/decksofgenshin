//TODO How to communicate deck message when posting and sent back to database
//TODO queue cardQueue localStorage

var cardQueue = [];
for(let i = 1;i<=30;i++){
    cardQueue.push(i);
}
let elemNum = (window.innerWidth *0.8 /95 -1) | 0 ;

let br = -1;

localStorage.clear();

function addCardToDeck(id,codeName,type,subType) {

    let elem = document.getElementById('cardList');
    let th = document.createElement('th');
    let botton = document.createElement('button');
    let img = document.createElement('img');
    let key = cardQueue.shift().toString();

    th.id = 'th_'+key;

    botton.className = 'button';
    botton.id = id+'botton';
    botton.addEventListener("click" , function() { deleteCardToDeck(th.id); },{once:true} );

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

    localStorage.setItem(key,codeName);
    addExportBox();
}

function deleteCardToDeck(thId) {

    let elem = document.getElementById(thId);
    elem.remove();
    let deleteKey = thId.replace("th_", "");

    localStorage.removeItem(deleteKey);
    cardQueue.push(parseInt(deleteKey));

    addExportBox();
}


function deleteCharaToDeck(colId) {

    let elem = document.getElementById(colId);
    let img = elem.querySelectorAll('img');

    let deleteKey = colId.replace("button", "");


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
