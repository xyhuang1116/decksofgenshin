//TODO How to communicate deck message when posting and sent back to database
//TODO queue 

var cardQueue = [];
for(let i = 1;i<=30;i++){
    cardQueue.push(i);
}
let elemNum = (window.innerWidth *0.8 /95 -1) | 0 ;

let br = -1;

let para = new URLSearchParams();

function addCardToDeck(id,codeName,type,subType) {

    let elem = document.getElementById('cardList');
    let th = document.createElement('th');
    let botton = document.createElement('button');
    let img = document.createElement('img');
    let key = cardQueue.shift().toString();

    th.id = 'th_'+key;

    botton.className = 'cardbutton';
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

    para.append(key,codeName);
    addExportBox();
}

function deleteCardToDeck(thId) {

    let elem = document.getElementById(thId);
    elem.remove();
    let deleteKey = thId.replace("th_", "");

    para.delete(deleteKey);
    cardQueue.push(parseInt(deleteKey));

    addExportBox();
}


function deleteCharaToDeck(colId) {

    let elem = document.getElementById(colId);
    let img = elem.querySelectorAll('img');

    let deleteKey = colId.replace("colbutton", "");


    para.delete(deleteKey);
    queue.push(parseInt(deleteKey));

    addExportBox();

    img[0].id = 'empty';
    img[0].src = '/image/empty_chara.png';
}


function addExportBox(){
    let deck = '';

    for(let value of para.values()) {
        deck = deck + value;
    }
    
    let deckCode = document.getElementById('deckCode');
    // deckCode.value = deck;
    deckCode.value = para.toString();
}

function get(){
    let para_main = new URLSearchParams(window.location.search),
        charaNames = para_main.getAll();
}

function goMain(){
    location.href = "main.html?" + para.toString();
}

// function addCharaToDeck(id,codeName) {

//     let elem = document.getElementById('row');
//     let imgs = elem.querySelectorAll('img');

//     for (let i = 0 ; i < imgs.length; i++) {
//         if(imgs[i].id == 'empty'){

//             imgs[i].id = 'full';
//             imgs[i].src= '/image/chara/icon/'.concat(id).concat('.png');

//             para.append(queue.shift().toString(),codeName);

//             addExportBox();

//             break;
//         }
//         else{continue;}
//     }
// }