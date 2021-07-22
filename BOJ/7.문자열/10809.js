const readline = require('readline')
 
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
})

let input = []
rl.on("line", function(line){
    input = line.split('')
}).on("close", function(){
    let answer = []
    for (let i = 97; i <= 122; i++) {
        answer.push(input.indexOf(String.fromCharCode(i)));
    }
    console.log(answer.join(" "))
})