<?php
test('test page contains hello world', function () {
    ob_start();
    include 'index.php';
    $html = ob_get_clean();
    
    expect($html)->toContain('Hello, World!');
});
?>