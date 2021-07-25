const readline = require('readline')
 
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
})
let input = []

rl.on("line", function(line){
    input.push(line)
}).on("close", function(){
    let splitArr = input[0].split("-")
    let positiveArr = splitArr.shift().split("+")
    let positiveSum = 0
    for (let i of positiveArr) positiveSum += Number(i)
    let negativeArr = splitArr.map((str)=>str.split("+")).flat()
    let negativeSum = 0
    for (let i of negativeArr) negativeSum += Number(i)
    console.log(positiveSum - negativeSum)
})