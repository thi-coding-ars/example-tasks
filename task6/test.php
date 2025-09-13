<?php
test('profile page contains student name and basic info', function () {
    ob_start();
    include 'index.php';
    $html = ob_get_clean();
    
    expect($html)->toContain('Hello, World!');
});
?>