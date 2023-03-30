//TODO How to pass deck data when posting and sent back to database
//TODO queue cardQueue 

let queue = [];
for(let i = 1;i<=3;i++){  // queue is now [1, 2, 3]
    queue.push(i); 
} 

let para = new URLSearchParams();


function addCharaToDeck(id,codeName) {

    let elem = document.getElementById('row');
    let imgs = elem.querySelectorAll('img');

    for (let i = 0 ; i < imgs.length; i++) {
        if(imgs[i].id == 'empty'){

            imgs[i].id = 'full';
            imgs[i].src= '/image/chara/icon/'.concat(id).concat('.png');

            para.append(queue.shift().toString(),codeName);

            addExportBox();

            break;
        }
        else{continue;}
    }
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
    let para_card = new URLSearchParams(window.location.search),
        charaNames = para_card.getAll();
}

function goCard(){
    location.href = "card.html?" + para.toString();
}