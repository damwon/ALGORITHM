const readline = require('readline')
 
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
})
const strToNum = (str) =>
    str.split(' ').map((numStr) => Number(numStr))

let input = []

rl.on("line", function(line){
    input.push(line)
}).on("close", function(){
    let T = parseInt(input.shift())
    let timeTable = input.map((str)=>strToNum(str))
    timeTable[0].sort((a,b) => a - b)
    let temp = 0
    let sum = 0
    for(let i=0; i<=T; i++) {
        temp += timeTable[0][i];
        timeTable[0][i] = temp;
    }
    
    for(let i=0; i<T; i++){
        sum += timeTable[0][i];
    }
    console.log(sum)
})