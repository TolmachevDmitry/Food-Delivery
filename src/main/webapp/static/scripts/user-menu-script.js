"use strict"

let starGradeForms = Array.from(document.getElementsByClassName("grade-form"));

starGradeForms.forEach(starGradeForm, () => {
    starGradeForm.addEventListener('submit', (ev) => {
        ev.preventDefault();
    
        const xhr = new XMLHttpRequest();
    
        const url = "/Food Delivery Application/dishes/delete?id=" + 
                        Number(new DataForm(dishDeleteButtons).get("id"));
    
        xhr.open("DELETE", url);
        xhr.send();
        
    })
});