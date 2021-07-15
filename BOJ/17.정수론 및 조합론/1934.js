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
    input.shift()
    let testTable = input.map((str)=>strToNum(str))
    for (let i of testTable) {
        let gcd = i[0];
        let a = i[1];
        while (a !== 0) {
          let r = gcd % a;
          gcd = a;
          a = r;
        }
        console.log(gcd * (i[0] / gcd) * (i[1] / gcd));
    }
})