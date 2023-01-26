//TODO How to communicate deck message when posting and sent back to database
//TODO queue cardQueue localStorage

var queue = [];
for(let i = 1;i<=3;i++){  // queue is now [1, 2, 3]
    queue.push(i); 
} 


localStorage.clear();

function addCharaToDeck(id,codeName) {

    let elem = document.getElementById('row');
    let imgs = elem.querySelectorAll('img');

    for (let i = 0 ; i < imgs.length; i++) {
        if(imgs[i].id == 'empty'){

            imgs[i].id = 'full';
            imgs[i].src= '/image/chara/icon/'.concat(id).concat('.png');

            localStorage.setItem(queue.shift().toString(),codeName);

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
