const readline = require('readline')
 
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
})

let input = []
rl.on("line", function(line){
    input.push(line.split(' '))
}).on("close", function(){
    let N = Number(input.shift())
    for (let i=0; i<N; i++) {
        let str = ""
        let S = []
        S.push(input[i][1].split(''))
        for (let j=0; j<(input[i][1].length); j++) {
            for (let k=0; k<Number(input[i][0]); k++){
                str += S[0][j]
            }
        }
        console.log(str)
    }
})
// 처음에 ''로 스플릿해서 계산했는데 이것이 오류였다.
// 이경우 1자리수 숫자반복만 가능하고 2자리가 되는순간 오류가난다.
// 테스트케이스는 전부 1자리 숫자반복이여서 오류를 캐치하는데 힘들었다. 

/*  오류코드
let input = []
rl.on("line", function(line){
    input.push(line.split('')) // 오류부분
}).on("close", function(){
    let N = Number(input[0][0])
    for (i=1; i<=N; i++) {
        let str = ''
        for (j=0; j<(input[i].length-2); j++) {
            for (k=0; k<input[i][0]; k++){
                str += input[i][j+2]
            }
        }
        console.log(str)
    }
})
*/