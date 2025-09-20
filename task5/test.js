test('should use semantic HTML5 elements correctly', () => {
    const hasP = await elementExists('p');
    expect(hasP, 'Add an <p> element to your body').toBe(true);

    const pText = await getTextContent('p');
    expect(pText, 'P should contain text "Hello, World!"').toBe('Hello, World!');
});
