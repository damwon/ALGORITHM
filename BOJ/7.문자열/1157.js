const readline = require('readline')
 
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
})

let input = []
rl.on("line", function(line){
    input.push(line.toUpperCase().split('')) // 인풋 문자 각자 대문자로 저장
}).on("close", function(){
    let set = new Set(input[0])   // 중복문자제외 오브젝트
    let dup = Array.from(set)    // 오브젝트를 배열로만듦
    let count = Array(dup.length).fill(0)   // 각 문자가 몇번나타났는지 세기위한 0초기화 배열
    for (i=0; i<input[0].length; i++){    //각 문자 카운트 세기
        for (j=0; j<dup.length; j++){
            if ( input[0][i] === dup[j]) {
                count[dup.indexOf(dup[j])] += 1
            }
        }
    }
    let max = Math.max(...count)    // 배열내 최댓값 구함
    let maxCnt = 0
    let answer = ''
    for (i=0; i<count.length; i++){ // 문제 조건에 맞게 answer에 저장
        if( max === count[i]) {
            maxCnt++
            answer = dup[i]
        }
    }

    if(maxCnt !== 1) {
        answer = '?'
    }

    console.log(answer)
})