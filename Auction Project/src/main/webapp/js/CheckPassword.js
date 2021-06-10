/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


 function checkPassword(){
                 pass1=document.signup.password.value;
                 pass2=document.signup.password2.value;
                
                if(pass1==pass2){
                    document.getElementById("msg").innerHTML = "Password Matched";
                    document.getElementById("msg").style.color="blue";
                }
                else{
                    document.getElementById("msg").innerHTML = "Password Not Matched";
                    document.getElementById("msg").style.color="red";
                }
            }