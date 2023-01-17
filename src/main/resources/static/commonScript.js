function unfoldContainer(){
    document.getElementById('row').style.bottom = '80%';
    document.getElementById('container').style.transform = 'translateY(20%)';
    document.getElementById('arrow').src = '/image/downArrow.png';

    let btn = document.getElementById('unfold');
    btn.setAttribute('onclick' , 'foldContainer()');
    btn.id = 'fold';
}

function foldContainer(){
    document.getElementById('row').style.bottom = 0;
    document.getElementById('container').style.transform = 'translateY(120%)';
    document.getElementById('arrow').src = '/image/arrow.png';

    let btn = document.getElementById('fold');
    btn.setAttribute('onclick' , 'unfoldContainer()');
    btn.id = 'unfold';
}
