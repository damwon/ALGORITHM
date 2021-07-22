const readline = require('readline')
 
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
})

let input = []
rl.on("line", function(line){
    input = line.split('')
}).on("close", function(){
    let answer = 0
    for(i=0; i<input.length; i++){
        answer += Number(input[i])
    }
    console.log(answer)
})