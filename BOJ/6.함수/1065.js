const readline = require('readline')
 
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
})

function f(n) {
    let num = n
    let sub = 0
    for (let i = 0; i < (String(num).length - 1); i++) {
        if(String(num).length === 1 || String(num).length === 2) {
            return n
        }
        sub = Number(String(num)[1]) - Number(String(num)[0])
        if(sub !== Number(String(num)[i+1]) - Number(String(num)[i])){
            return false
        }
    }
    return n
}

let input = 0
rl.on("line", function(line){
    input = Number(line)
}).on("close", function(){
    let ary = []
    for (i=1; i <=input; i++) {
        if(f(i) !== false){
            ary.push(f(i))
        }
    }
    console.log(ary.length)
})
