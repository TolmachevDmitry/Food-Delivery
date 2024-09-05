"use strict"

let dishDeleteButtons = Array.from(document.getElementsByClassName("dish-delete-form"));


dishDeleteButtons.forEach(button, () => {
    button.addEventListener('submit', (ev) => {
        ev.preventDefault();

        console.log("Выполняется запрос на удалние по id: " + new DataForm(dishDeleteButtons).get("id"));
    
        const xhr = new XMLHttpRequest();
    
        const url = "/Food Delivery Application/dishes/delete?id=" + 
                        Number(new DataForm(dishDeleteButtons).get("id"));
    
        xhr.open("DELETE", url);
        xhr.send();
        
    })
});