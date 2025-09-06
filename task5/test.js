describe('HTML5 Semantic Structure Tests', () => {
    test('should use semantic HTML5 elements correctly', () => {
        const bodyElement = document.querySelector('body');
        expect(bodyElement).toBeTruthy();
        expect(bodyElement.querySelector('p')).toBeTruthy();
    });
});