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
    let testTable = input.map((str)=>strToNum(str))
    for(let i of testTable) {
        if (i[1]%i[0] === 0) {        //1번숫자가 2번숫자의 약수일때
            console.log("factor")
        } else if (i[0]%i[1] === 0) { //1번숫자가 2번숫자의 배수일때
            console.log("multiple")
        } else if (i[1] === i[0]) {   //1번숫자와 2번숫자가 같을때(0,0일때) *두수가 같은 경우는 없기때문
            return
        } else {
            console.log("neither")    //약수와 배수 모두 아닐때
        } 
    }
})
//두수가같은경우는 0,0밖에 없기때문에 (i[0]===0 && i[1]===0)라고 조건문을 쓰지 않았다.