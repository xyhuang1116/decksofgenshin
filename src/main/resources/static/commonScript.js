function unfoldContainer(){
    document.getElementById('row').style.bottom = '80%';
    document.getElementById('container').style.transform = 'translateY(20%)';
    document.getElementById('arrow').src = '/image/downArrow.png';

    let btn = document.getElementById('unfold');

    btn.addEventListener("click",foldContainer,{once:true});
    btn.id = 'fold';
}

function foldContainer(){
    document.getElementById('row').style.bottom = 0;
    document.getElementById('container').style.transform = 'translateY(120%)';
    document.getElementById('arrow').src = '/image/arrow.png';

    let btn = document.getElementById('fold');

   
    btn.addEventListener("click",unfoldContainer,{once:true});
    btn.id = 'unfold';
}
