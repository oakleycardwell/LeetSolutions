class Solution(object):
    def letterCombinations(self, digits):
        if not digits:
            return []

        digit_map = {
            '2': 'abc',
            '3': 'def',
            '4': 'ghi',
            '5': 'jkl',
            '6': 'mno',
            '7': 'pqrs',
            '8': 'tuv',
            '9': 'wxyz'
        }

        def generate_combinations(index, current_combination, result):
            if index == len(digits):
                result.append(current_combination)
                return

            current_digit = digits[index]
            letters = digit_map[current_digit]

            for letter in letters:
                generate_combinations(index + 1, current_combination + letter, result)

        result = []
        generate_combinations(0, '', result)
        return result
    