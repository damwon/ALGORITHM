const readline = require('readline')
 
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
})
let input = []
let num = []
rl.on("line", function(line){
    input.push(line)
}).on("close", function(){
    let A = Number(input[0])
    let B = Number(input[1])
    num = String(B).split('')
    let P = num[0]
    let Q = num[1]
    let R = num[2]
    console.log(A*R)
    console.log(A*Q)
    console.log(A*P)
    console.log(A*B)
})